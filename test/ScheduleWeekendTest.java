import com.github.arturkh.activity.schedule.ScheduleWeekend;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ScheduleWeekendTest {

    @Test
    void performingPlan__withWeekend__isActiveFalse() {
        LocalDate today = LocalDate.of(2019, 7, 13);

        ScheduleWeekend scheduleWeekend = new ScheduleWeekend();

        assertThat(scheduleWeekend.isActive(today), is(false));
    }

    @Test
    void performingPlan__withCorrectWeekdays__isActiveTrue() {
        LocalDate today = LocalDate.of(2019, 7, 15);

        ScheduleWeekend scheduleWeekend = new ScheduleWeekend();

        assertThat(scheduleWeekend.isActive(today), is(true));
    }
}
