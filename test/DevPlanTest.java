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
        University chdtu = new University();
        chdtu.setKnowledgeOfOneDay(5);
        chdtu.setPracticeOfOneDay(2);
        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));
        devPlan.addActivity(chdtu, asList(new ScheduleWeekend()));

        devPlan.perform(oksana, Collections.singletonList(today));

        assertThat(oksana.getKnowledge(), is(7));
    }

    @Test
    void performingPlan__withTwoSchedules__increaseStudentKnowledge() {
        List<LocalDate> period = today.datesUntil(LocalDate.of(2019, Month.JULY, 12)).collect(Collectors.toList());
        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);
        DevPlan devPlan = new DevPlan();
        University chdtu = new University();
        chdtu.setKnowledgeOfOneDay(5);
        chdtu.setPracticeOfOneDay(2);
        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));
        devPlan.addActivity(chdtu, asList(new SchedulePeriod(firstDay, lastDay)));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(14));
    }
    @Test
    void performingPlan__withTwoSchedules__increaseStudentKnowledgeByOneSchedule() {
        List<LocalDate> period = today.datesUntil(LocalDate.of(2019, Month.JULY, 10)).collect(Collectors.toList());

        LocalDate today = LocalDate.now();
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);

        DevPlan devPlan = new DevPlan();
        University chdtu = new University();
        chdtu.setKnowledgeOfOneDay(5);
        chdtu.setPracticeOfOneDay(2);

        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend(), new SchedulePeriod(firstDay , lastDay), new ScheduleWeekend(), new ScheduleWeekend()));
        devPlan.addActivity(chdtu, asList(new SchedulePeriod(firstDay , lastDay)));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(0));
    }

    @Test
    void reduce() {
        List<Integer> integers = asList(1, 2, 3);

        int sum = integers.stream().reduce(0, Integer::sum);

        assertThat(sum, is(6));
    }
}
