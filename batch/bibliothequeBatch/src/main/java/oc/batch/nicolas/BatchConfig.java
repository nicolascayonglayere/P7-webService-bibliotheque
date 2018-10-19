package oc.batch.nicolas;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableBatchProcessing
public class BatchConfig extends DefaultBatchConfigurer {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Step step() {
		return this.stepBuilderFactory.get("step").tasklet(new EnvoiMailRetardataires()).build();
	}

	@Bean
	@Scheduled(cron = "0 1 1 * * ?")
	public Job job() {
		return this.jobBuilderFactory.get("job").start(this.step()).build();
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		// This BatchConfigurer ignores any DataSource
	}
}
