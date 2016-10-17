package com.app.test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

import com.app.runtime.Executor;
import com.app.runtime.IExecutor;
import com.app.util.StringConstant;

public class CommandTest {

	@Test
	public void test() {
				
		IExecutor executor = new Executor();
		String command = StringConstant.CPU_FEATURES_COMMAND;		
		List<String> runCommand = executor.runCommand(command);
		assertTrue(runCommand != null);
					
	}

}
