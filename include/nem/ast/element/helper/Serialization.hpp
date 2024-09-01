#pragma once

#include "ForEach.hpp"

//////////////////////////
// Serialization macros //
//////////////////////////

#define NEM_DEFINE_ALL_AST_TYPES_SERIALIZATION                          \
	NEM_EVAL(NEM_FOR_EACH_AST_ENUMS(NEM_DEFINE_AST_ENUM_SERIALIZATION)) \
	NEM_EVAL(NEM_FOR_EACH_AST_STRUCTS(NEM_DEFINE_AST_STRUCT_SERIALIZATION))

#define NEM_DEFINE_AST_STRUCT_SERIALIZATION(S)                      \
	template<class Archive>                                         \
	void serialize(Archive& ar, S##Node& s)                         \
	{                                                               \
		NEM_FOR_EACH_AST_STRUCT_ATTRIB_OF(S, NEM_ARCHIVE_SERIALIZE) \
	}

#define NEM_ARCHIVE_SERIALIZE_DETAILS(T, N) ar(cereal::make_nvp(#N, s.N));
#define NEM_ARCHIVE_SERIALIZE(F)			NEM_ARCHIVE_SERIALIZE_DETAILS F

#define NEM_DEFINE_AST_ENUM_SERIALIZATION(E)    \
	template<class Archive>                     \
	void serialize(Archive& ar, E##Node& e)     \
	{                                           \
		ar(cereal::make_nvp("value", e.value)); \
	}
