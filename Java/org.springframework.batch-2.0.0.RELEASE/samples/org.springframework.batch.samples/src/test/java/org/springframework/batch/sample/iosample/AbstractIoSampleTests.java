package org.springframework.batch.sample.iosample;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStream;
import org.springframework.batch.sample.domain.trade.CustomerCredit;
import org.springframework.batch.sample.domain.trade.internal.CustomerCreditIncreaseProcessor;
import org.springframework.batch.test.AbstractJobTests;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Base class for IoSample tests that increase input customer credit by fixed
 * amount. Assumes inputs and outputs are in the same format and uses the job's
 * {@link ItemReader} to parse the outputs.
 * 
 * @author Robert Kasanicky
 */
public abstract class AbstractIoSampleTests extends AbstractJobTests {

	@Autowired
	private ItemReader<CustomerCredit> reader;

	/**
	 * Check the resulting credits correspond to inputs increased by fixed
	 * amount.
	 */
	@Test
	public void testUpdateCredit() throws Exception {

		open(reader);
		List<CustomerCredit> inputs = getCredits(reader);
		close(reader);

		JobExecution jobExecution = this.launchJob();
		assertEquals(BatchStatus.COMPLETED, jobExecution.getStatus());

		pointReaderToOutput(reader);
		open(reader);
		List<CustomerCredit> outputs = getCredits(reader);
		close(reader);

		assertEquals(inputs.size(), outputs.size());
		int itemCount = inputs.size();
		assertTrue(itemCount > 0);
		
		for (int i = 0; i < itemCount; i++) {
			assertEquals(inputs.get(i).getCredit().add(CustomerCreditIncreaseProcessor.FIXED_AMOUNT).intValue(),
					outputs.get(i).getCredit().intValue());
		}

	}

	/**
	 * Configure the reader to read outputs (if necessary). Required for
	 * file-to-file jobs jobs, usually no-op for database jobs where inputs are
	 * updated (rather than outputs created).
	 */
	protected abstract void pointReaderToOutput(ItemReader<CustomerCredit> reader);

	/**
	 * Read all credits using the provided reader.
	 */
	private List<CustomerCredit> getCredits(ItemReader<CustomerCredit> reader) throws Exception {
		CustomerCredit credit;
		List<CustomerCredit> result = new ArrayList<CustomerCredit>();
		while ((credit = reader.read()) != null) {
			result.add(credit);
		}
		return result;

	}

	/**
	 * Open the reader if applicable.
	 */
	private void open(ItemReader<?> reader) {
		if (reader instanceof ItemStream) {
			((ItemStream) reader).open(new ExecutionContext());
		}
	}

	/**
	 * Close the reader if applicable.
	 */
	private void close(ItemReader<?> reader) {
		if (reader instanceof ItemStream) {
			((ItemStream) reader).close();
		}
	}

}
