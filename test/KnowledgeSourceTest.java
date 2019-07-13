import com.github.arturkh.activity.DevPlan;
import com.github.arturkh.activity.Student;
import com.github.arturkh.activity.knowledgeSource.Institutions;
import com.github.arturkh.activity.knowledgeSource.Meetup;
import com.github.arturkh.activity.schedule.ScheduleHolidays;
import com.github.arturkh.activity.schedule.ScheduleOneDayOfMonth;
import com.github.arturkh.activity.schedule.SchedulePeriod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class KnowledgeSourceTest {
    private Student oksana;
    private LocalDate today;

    @BeforeEach
    void setUp() {
        oksana = new Student("Oksana", false, 1.0);
        today = LocalDate.now();
    }

    @Test
    void performingPlan__withMeetup__increaseKnowledgeLevel() {
        LocalDate today = LocalDate.now();
        List<LocalDate> period = today.datesUntil(today.plusDays(21)).collect(Collectors.toList());
        ScheduleOneDayOfMonth scheduleOneDayOfMonth = new ScheduleOneDayOfMonth(DayOfWeek.FRIDAY);
        Meetup meetup = new Meetup(2,1,false);

        DevPlan devPlan = new DevPlan();

        devPlan.addActivity(meetup, asList(scheduleOneDayOfMonth));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(2));
    }

    @Test
    void performingPlan__withSelfEducation__increaseKnowledgeLevel() {
        LocalDate today = LocalDate.of(2019, Month.JULY, 10);
        Month summerHolidays = Month.JULY;

        ScheduleHolidays scheduleHolidays = new ScheduleHolidays(summerHolidays);

        assertThat(scheduleHolidays.isActive(today), is(false));
    }

    @Test
    void performingPlan__withStudentEducation__increaseKnowledgeLevel() {
        LocalDate today = LocalDate.of(2019, Month.JULY, 10);
        Month summerHolidays = Month.JULY;

        ScheduleHolidays scheduleHolidays = new ScheduleHolidays(summerHolidays);

        assertThat(scheduleHolidays.isActive(today), is(false));
    }
}
