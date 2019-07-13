import com.github.arturkh.activity.DevPlan;
import com.github.arturkh.activity.Student;
import com.github.arturkh.activity.knowledgeSource.SelfEducation;
import com.github.arturkh.activity.schedule.ScheduleOneDayOfMonth;
import com.github.arturkh.activity.schedule.SchedulePeriod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KnowledgeSourceTest {
    private Student oksana;
    private Student grisha;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        oksana = new Student("Oksana", false, 1.0);
        grisha = new Student("Grisha", true, 1.0);
        today = LocalDate.now();
    }

    @Test
    void performingPlan__withSelfEducation__increaseKnowledgeLevel() {
        LocalDate today = LocalDate.now();
        List<LocalDate> period = today.datesUntil(today.plusDays(21)).collect(Collectors.toList());
        ScheduleOneDayOfMonth scheduleOneDayOfMonth = new ScheduleOneDayOfMonth(DayOfWeek.FRIDAY);
        SelfEducation selfEducation = new SelfEducation(2,1);

        DevPlan devPlan = new DevPlan();

        devPlan.addActivity(selfEducation, asList(scheduleOneDayOfMonth));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(2));
    }

    @Test
    void performingPlan__withStudentEducation__increaseKnowledgeLevel() {
        LocalDate today = LocalDate.now();
        List<LocalDate> period = today.datesUntil(today.plusDays(21)).collect(Collectors.toList());
        LocalDate firstDay = today.minusDays(15);
        LocalDate lastDay = today.plusDays(21);
        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, lastDay);
        SelfEducation selfEducation = new SelfEducation(2,1);
        DevPlan devPlan = new DevPlan();
        devPlan.addActivity(selfEducation, asList(schedulePeriod));
        devPlan.perform(oksana, period);


        ScheduleOneDayOfMonth scheduleOneDayOfMonth = new ScheduleOneDayOfMonth(DayOfWeek.FRIDAY);

        DevPlan anotherDevPlan = new DevPlan();

        anotherDevPlan.addActivity(oksana.educate(grisha), asList(scheduleOneDayOfMonth));

        anotherDevPlan.perform(oksana, period);

        assertThat(grisha.getKnowledge(), is(oksana.getKnowledge() / 10));
    }
}
