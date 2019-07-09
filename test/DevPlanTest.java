import com.github.arturkh.activity.DevPlan;
import com.github.arturkh.activity.Student;
import com.github.arturkh.activity.knowledgeSource.Internship;
import com.github.arturkh.activity.knowledgeSource.University;
import com.github.arturkh.activity.schedule.SchedulePeriod;
import com.github.arturkh.activity.schedule.ScheduleWeekend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

public class DevPlanTest {

    private Student oksana;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        oksana = new Student("Oksana", false, 1.0);
        today = LocalDate.now();
    }

    @Test
    void performingPlan__withoutActivity__givesNoEffect() {
        // given
        DevPlan devPlan = new DevPlan();

        // when
        devPlan.perform(oksana, Collections.singletonList(today));

        // then
        assertThat(oksana.getKnowledge(), is(0));
    }

    @Test
    void performingPlan__withOneKnowledgeSource__increaseStudentKnowledge() {
        DevPlan devPlan = new DevPlan();

        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));

        devPlan.perform(oksana, Collections.singletonList(today));

        assertThat(oksana.getKnowledge(), is(2));
    }

    @Test
    void performingPlan__withTwoElementsInDevPlan__increaseStudentKnowledge() {
        DevPlan devPlan = new DevPlan();
        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));
        devPlan.addActivity(new University(), asList(new ScheduleWeekend()));

        devPlan.perform(oksana, Collections.singletonList(today));

        assertThat(oksana.getKnowledge(), is(8));
    }

    @Test
    void performingPlan__withTwoSchedules__increaseStudentKnowledge() {
        List<LocalDate> period = today.datesUntil(LocalDate.of(2019, Month.JULY, 10)).collect(Collectors.toList());
        DevPlan devPlan = new DevPlan();
        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));
        devPlan.addActivity(new University(), asList(new SchedulePeriod(period)));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(8));
    }
    @Test
    void performingPlan__withTwoSchedules__increaseStudentKnowledgeByOneSchedule() {
        List<LocalDate> period = today.datesUntil(LocalDate.of(2019, Month.JULY, 10)).collect(Collectors.toList());
        List<LocalDate> periodBeforeNow = LocalDate.of(2018, Month.JULY, 10).datesUntil(LocalDate.of(2019, Month.JULY, 10)).collect(Collectors.toList());
        DevPlan devPlan = new DevPlan();
        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));
        devPlan.addActivity(new University(), asList(new SchedulePeriod(periodBeforeNow)));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(2));
    }

}
