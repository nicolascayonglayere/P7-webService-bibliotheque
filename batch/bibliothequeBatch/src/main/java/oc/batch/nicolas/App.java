package oc.batch.nicolas;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Hello world!
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@EnableScheduling
public class App implements CommandLineRunner {

	@Autowired
	private JobLauncher jobLauncher;

	@Autowired
	private Job job;

	public static void main(String[] args) {
		System.out.println("Hello World!");
		SpringApplication.run(App.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		JobParameters params = new JobParametersBuilder().addString("JobID", String.valueOf(System.currentTimeMillis()))
				.toJobParameters();
		this.jobLauncher.run(this.job, params);
	}

	public JobLauncher getJobLauncher() {
		return this.jobLauncher;
	}

	// @Autowired
	public void setJobLauncher(JobLauncher jobLauncher) {
		this.jobLauncher = jobLauncher;
	}

	public Job getJob() {
		return this.job;
	}

	// @Autowired
	public void setJob(Job job) {
		this.job = job;
	}
}
