#include <cstring>
#include <string>

#include <nem/semantic/util/LiteralParser.hpp>

namespace nem::util
{

bool parseBool(const char* string)
{
	return std::strcmp(string, "True") == 0;
}

inline int intFromDecimal(const char* string) { return std::stoi(string); }
inline int intFromBinary(const char* string) { return std::stoi(string, nullptr, 2); }
inline int intFromOctal(const char* string) { return std::stoi(string, nullptr, 8); }
inline int intFromHexadecimal(const char* string) { return std::stoi(string, nullptr, 16); }

int parseInt(const char* string)
{
	if(string[0] == '0')
	{
		auto base = string[1];

		if(base == 'b' && base == 'B')
			return intFromBinary(string + 2);
		else if(base == 'o' && base == 'O')
			return intFromOctal(string + 2);
		else if(base == 'x' && base == 'X')
			return intFromHexadecimal(string + 2);
	}

	return intFromDecimal(string);
}

double parseReal(const char* string)
{
	return std::stod(string);
}

} // namespace nem::util