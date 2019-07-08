import com.github.arturkh.activity.DevPlan;
import com.github.arturkh.activity.Student;
import com.github.arturkh.activity.knowledgeSource.Internship;
import com.github.arturkh.activity.knowledgeSource.KnowledgeSource;
import com.github.arturkh.activity.knowledgeSource.University;
import com.github.arturkh.activity.schedule.Schedule;
import com.github.arturkh.activity.schedule.ScheduleWeekend;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

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
        devPlan.perform(oksana, today);

        // then
        assertThat(oksana.getKnowledge(), is(0));
    }

    @Test
    void performingPlan__withOneKnowledgeSource__increaseStudentKnowledge() {
        DevPlan devPlan = new DevPlan();

        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));

        devPlan.perform(oksana, today);

        assertThat(oksana.getKnowledge(), is(2));
    }

    @Test
    void performingPlan__withTwoElementsInDevPlan__increaseStudentKnowledge() {
        DevPlan devPlan = new DevPlan();
        devPlan.addActivity(new Internship(), asList(new ScheduleWeekend()));
        devPlan.addActivity(new University(), asList(new ScheduleWeekend()));

        devPlan.perform(oksana, today);

        assertThat(oksana.getKnowledge(), is(8));
    }

}
