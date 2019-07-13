import com.github.arturkh.activity.schedule.ScheduleHolidays;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScheduleHolidaysTest {

    @Test
    void performingPlan__withIncorrectMonth__isActiveTrue() {
        LocalDate today = LocalDate.of(2019,Month.MARCH,10);
        Month summerHolidays = Month.JULY;

        ScheduleHolidays scheduleHolidays = new ScheduleHolidays(summerHolidays);

        assertThat(scheduleHolidays.isActive(today), is(true));
    }
    @Test
    void performingPlan__withCorrectMonth__isActiveFalse() {
        LocalDate today = LocalDate.of(2019,Month.JULY,10);
        Month summerHolidays = Month.JULY;

        ScheduleHolidays scheduleHolidays = new ScheduleHolidays(summerHolidays);

        assertThat(scheduleHolidays.isActive(today), is(false));
    }
}
