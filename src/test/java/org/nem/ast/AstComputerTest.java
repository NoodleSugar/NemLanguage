package org.nem.ast;

import org.junit.jupiter.api.Test;
import org.nem.ast.expression.ExprLValue;
import org.nem.ast.expression.ExprNum;
import org.nem.ast.function.Function;
import org.nem.ast.function.Parameter;
import org.nem.ast.instruction.*;
import org.nem.ast.type.Type;
import org.nem.ast.type.TypeFactory;
import org.nem.ast.value.LValueVar;

import java.io.IOException;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class AstComputerTest {
	private static final String BASIC_FN_DEF = "basic_fn_def.nem";

	private static final Type VOID_TYPE = TypeFactory.get("void");
	private static final Type INT_TYPE = TypeFactory.get("int");

	@Test
	public void basicFnDef() throws IOException {
		final InputStream fileStream = getClass().getResourceAsStream(BASIC_FN_DEF);
		FileContent content = AstComputer.parseFileContent(fileStream);

		assertNotNull(content);
		assertEquals(1, content.functions.size());

		// Function checks

		Function f = content.functions.get("f");
		assertNotNull(f);
		assertEquals("f", f.name);
		assertEquals(VOID_TYPE, f.returnType);
		assertEquals(1, f.parameters.size());
		assertEquals(6, f.instructions.size());

		// Parameter checks

		Parameter p = f.parameters.get(0);
		assertTrue(p.name.isPresent());
		assertEquals("p", p.name.get());

		// Instruction checks

		Instruction i1 = f.instructions.get(0);
		Instruction i2 = f.instructions.get(1);
		Instruction i3 = f.instructions.get(2);
		Instruction i4 = f.instructions.get(3);
		Instruction i5 = f.instructions.get(4);
		Instruction i6 = f.instructions.get(5);

		assertTrue(i1 instanceof ConstDef);
		assertTrue(i2 instanceof ConstDef);
		assertTrue(i3 instanceof VarDecl);
		assertTrue(i4 instanceof VarDef);
		assertTrue(i5 instanceof VarDef);
		assertTrue(i6 instanceof Assignment);

		ConstDef cDef1 = (ConstDef) i1;
		ConstDef cDef2 = (ConstDef) i2;
		VarDecl vDecl = (VarDecl) i3;
		VarDef vDef1 = (VarDef) i4;
		VarDef vDef2 = (VarDef) i5;
		Assignment assign = (Assignment) i6;

		// Declaration and definition checks

		assertEquals("a", cDef1.name);
		assertEquals("b", cDef2.name);
		assertEquals("c", vDecl.name);
		assertEquals("d", vDef1.name);
		assertEquals("e", vDef2.name);

		assertTrue(cDef1.type.isEmpty());
		assertTrue(cDef2.type.isPresent());
		assertTrue(vDef1.type.isEmpty());
		assertTrue(vDef2.type.isPresent());

		assertEquals(INT_TYPE, vDecl.type);
		assertEquals(INT_TYPE, cDef2.type.get());
		assertEquals(INT_TYPE, vDef2.type.get());

		assertTrue(cDef1.expression instanceof ExprNum);
		assertTrue(cDef2.expression instanceof ExprNum);
		assertTrue(vDef1.expression instanceof ExprNum);
		assertTrue(vDef1.expression instanceof ExprNum);

		ExprNum cDef1Num = (ExprNum) cDef1.expression;
		ExprNum cDef2Num = (ExprNum) cDef2.expression;
		ExprNum vDef1Num = (ExprNum) vDef1.expression;
		ExprNum vDef2Num = (ExprNum) vDef2.expression;

		assertEquals("2", cDef1Num.value);
		assertEquals("0b11", cDef2Num.value);
		assertEquals("0o77", vDef1Num.value);
		assertEquals("0xff", vDef2Num.value);

		// Assignment checks

		assertEquals(AssignOp.AddEqual, assign.op);
		assertTrue(assign.left instanceof LValueVar);
		assertTrue(assign.right instanceof ExprLValue);
		assertTrue(((ExprLValue)assign.right).lvalue instanceof LValueVar);

		LValueVar leftAssignVar = (LValueVar) assign.left;
		LValueVar rightAssignVar = (LValueVar) ((ExprLValue)assign.right).lvalue;

		assertEquals("a", leftAssignVar.name);
		assertEquals("b", rightAssignVar.name);
	}
}
