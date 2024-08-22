#include <boost/preprocessor/seq/for_each.hpp>
#include <boost/preprocessor/seq/to_tuple.hpp>
#include <boost/preprocessor/variadic/to_seq.hpp>

#define NEM_EVAL(...) __VA_ARGS__
#define NEM_EMPTY()
#define NEM_DEFER(id) id NEM_EMPTY()()
#define NEM_UNPACK(F) NEM_EVAL F

#define NEM_BOOST_MACRO(I, D, X) D(X)
#define NEM_FOR_EACH(X, ...) \
	BOOST_PP_SEQ_FOR_EACH(   \
	 NEM_BOOST_MACRO,        \
	 X,                      \
	 BOOST_PP_VARIADIC_TO_SEQ(__VA_ARGS__))
#define NEM_FOR_EACH_INDIRECT() NEM_FOR_EACH
#define NEM_FOR_EACH_DEFERED	NEM_DEFER(NEM_FOR_EACH_INDIRECT)

#define NEM_BOOST_ADAPT_MACRO(I, D, X) (D(X))
#define NEM_ADAPT_LIST(X, ...) \
	NEM_UNPACK(                \
	 BOOST_PP_SEQ_TO_TUPLE(    \
	  BOOST_PP_SEQ_FOR_EACH(   \
	   NEM_BOOST_ADAPT_MACRO,  \
	   X,                      \
	   BOOST_PP_VARIADIC_TO_SEQ(__VA_ARGS__))))