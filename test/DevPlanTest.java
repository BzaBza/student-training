import com.github.arturkh.activity.DevPlan;
import com.github.arturkh.activity.Student;
import com.github.arturkh.activity.knowledgeSource.Institutions;
import com.github.arturkh.activity.knowledgeSource.SelfEducation;
import com.github.arturkh.activity.schedule.SchedulePeriod;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
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
    void performingPlan__withInstitutionNotEnroll__notIncreaseStudentKnowledge() {
        DevPlan devPlan = new DevPlan();
        Institutions university = new Institutions(2, 3);
        devPlan.addActivity(university, asList());

        devPlan.perform(oksana, Collections.singletonList(today));

        assertThat(oksana.getKnowledge(), is(0));
    }

    @Test
    void performingPlan__withTwoElementsInDevPlan__increaseStudentKnowledge() {
        DevPlan devPlan = new DevPlan();
        Institutions university = new Institutions(7, 3);
        SelfEducation selfEducation = new SelfEducation(1, 1);
        university.enrollStudent(oksana);
        devPlan.addActivity(university, asList());
        devPlan.addActivity(selfEducation, asList());

        devPlan.perform(oksana, Collections.singletonList(today));

        assertThat(oksana.getKnowledge(), is(8));
    }


    @Test
    void performingPlan__withTwoSchedules__increaseStudentKnowledgeByOneSchedule() {
        LocalDate today = LocalDate.now();
        List<LocalDate> period = today.datesUntil(today.plusDays(1)).collect(Collectors.toList());
        LocalDate firstDay = today.minusDays(1);
        LocalDate lastDay = today.plusDays(1);
        Institutions institutions = new Institutions(5 , 2);
        institutions.enrollStudent(oksana);
        DevPlan devPlan = new DevPlan();

        devPlan.addActivity(institutions, asList(new SchedulePeriod(firstDay , lastDay)));

        devPlan.perform(oksana, period);

        assertThat(oksana.getKnowledge(), is(5));
    }

    @Test
    void reduce() {
        List<Integer> integers = asList(1, 2, 3);

        int sum = integers.stream().reduce(0, Integer::sum);

        assertThat(sum, is(6));
    }
}
