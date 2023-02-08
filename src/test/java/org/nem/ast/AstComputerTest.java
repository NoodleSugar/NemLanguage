package org.nem.ast;

import org.junit.Test;
import org.nem.ast.function.Function;
import org.nem.ast.type.TypeFactory;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class AstComputerTest {
	final String BASIC_FN_DEF = "basic_fn_def.nem";

	@Test
	public void basicFnDef() throws IOException {
		final InputStream fileStream = getClass().getResourceAsStream(BASIC_FN_DEF);
		FileContent content = AstComputer.parseFileContent(fileStream);

		assertNotNull(content);
		assertEquals(1, content.functions.size());

		Function f = content.functions.get(0);

		assertEquals("f", f.name);
		assertEquals(TypeFactory.get("void"), f.returnType);

		assertEquals(1, f.parameters.size());

		Parameter p = f.parameters.get(0);
		assertTrue(f.parameters.get(0).name.isPresent());
		assertEquals(f.name);
	}
}
