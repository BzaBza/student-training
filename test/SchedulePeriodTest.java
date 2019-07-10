import com.github.arturkh.activity.schedule.SchedulePeriod;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SchedulePeriodTest {

    @Test
    void performingPlan__withAfterPerformDate__increaseStudentKnowledgeByOneSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);
        LocalDate afterPeriod = today.plusDays(2);

        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, lastDay);

        assertThat(schedulePeriod.isActive(afterPeriod), is(false));
    }
    @Test
    void performingPlan__withBeforePerformDate__increaseStudentKnowledgeByOneSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);
        LocalDate afterPeriod = today.minusDays(2);

        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, lastDay);

        assertThat(schedulePeriod.isActive(afterPeriod), is(false));
    }
    @Test
    void performingPlan__withCorrectDate__increaseStudentKnowledgeByOneSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);

        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, lastDay);

        assertThat(schedulePeriod.isActive(today), is(true));
    }
    @Test
    void performingPlan__withDateFirstDay__increaseStudentKnowledgeByOneSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);

        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, lastDay);

        assertThat(schedulePeriod.isActive(firstDay), is(true));
    }
    @Test
    void performingPlan__withDateLastDay__increaseStudentKnowledgeByOneSchedule() {
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);

        SchedulePeriod schedulePeriod = new SchedulePeriod(firstDay, lastDay);

        assertThat(schedulePeriod.isActive(lastDay), is(true));
    }
}
