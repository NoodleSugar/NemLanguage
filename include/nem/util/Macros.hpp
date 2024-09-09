#pragma once

#include <boost/preprocessor/seq/for_each.hpp>
#include <boost/preprocessor/variadic/to_seq.hpp>

#define NEM_BOOST_MACRO(I, D, X) D(X)
#define NEM_FOR_EACH(X, ...) \
	BOOST_PP_SEQ_FOR_EACH(   \
	 NEM_BOOST_MACRO,        \
	 X,                      \
	 BOOST_PP_VARIADIC_TO_SEQ(__VA_ARGS__))

#define NEM_DECLARE_STRUCT(S) struct S;
