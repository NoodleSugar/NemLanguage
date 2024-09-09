#include <catch2/catch_test_macros.hpp>
#include <catch2/generators/catch_generators.hpp>

#include "nem/ir/util/LiteralParser.hpp"

using namespace nem::ir;

TEST_CASE("ParseInt")
{
	struct Data
	{
		std::string code;
		int			expected;
	};

	auto data = GENERATE(
	 Data{"0", 0},
	 Data{"0001", 1},
	 Data{"1", 1},
	 Data{"1234", 1234},
	 Data{"0b10110100", 0b10110100},
	 Data{"0o2717", 02717},
	 Data{"0x10CDFFFF", 0x10CDFFFF});

	CHECK(data.expected == parseInt(data.code.c_str()));
}

TEST_CASE("ParseReal")
{
	struct Data
	{
		std::string code;
		double		expected;
	};

	auto data = GENERATE(
	 Data{"0.0", 0.0},
	 Data{"1e02", 1e02},
	 Data{"0.12e-10", 0.12e-10});

	CHECK(data.expected == parseReal(data.code.c_str()));
}
