package zad1.testJBehave;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jbehave.core.configuration.Configuration;
import org.jbehave.core.configuration.MostUsefulConfiguration;
import org.jbehave.core.io.CodeLocations;
import org.jbehave.core.io.LoadFromURL;
import org.jbehave.core.io.StoryFinder;
import org.jbehave.core.junit.JUnitStories;
import org.jbehave.core.reporters.FilePrintStreamFactory;
import org.jbehave.core.reporters.Format;
import org.jbehave.core.reporters.StoryReporterBuilder;
import org.jbehave.core.steps.InjectableStepsFactory;
import org.jbehave.core.steps.InstanceStepsFactory;


import zad1.testJBehave.steps.FizzBuzzStepsRunner;

/**
 * generic binder for all JBehave tests. Binds all the story files to the
 * step files. works for both Eclipse and Maven command line build.
 * @author funktapuss
 *
 */
public class QuadraticFunctionRunnerStories extends JUnitStories {

    @Override
    public Configuration configuration(){
        return new MostUsefulConfiguration().useStoryReporterBuilder(getReporter()).
                useStoryLoader(new LoadFromURL());
    }

    @Override
    protected List<String> storyPaths() {
        String path = "stories/**/*.story";
        return new StoryFinder().findPaths(CodeLocations.codeLocationFromPath("").getFile(),
                Collections.singletonList(path),
                new ArrayList<String>(), "file:");
    }

    @Override
    public InjectableStepsFactory stepsFactory(){
        return new InstanceStepsFactory(configuration(), new FizzBuzzStepsRunner());
    }

    private StoryReporterBuilder getReporter(){
        return new StoryReporterBuilder().withPathResolver(new FilePrintStreamFactory.ResolveToSimpleName()
        ).withDefaultFormats().withFormats(Format.CONSOLE, Format.HTML);
    }

}
