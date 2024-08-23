#pragma once

namespace nem
{

template<class... Ts>
struct VisitorOverload : Ts...
{
	using Ts::operator()...;
};

template<class... Ts>
VisitorOverload(Ts...) -> VisitorOverload<Ts...>;

} // namespace nem
