package club.doki7.babel.extract.shaderc

import club.doki7.babel.cdecl.EnumeratorDecl
import club.doki7.sennaar.registry.Member

object EnumeratorName : AbstractKey<String>("enumeratorName")
object Enumerators : AbstractKey<MutableList<Pair<EnumeratorDecl, List<String>?>>>("enumerators")
object Doxygen : AbstractKey<List<String>>("doxygen")
object EnumerationDoxygen : AbstractKey<List<String>>("enumerationDoxygen")
object Fields : AbstractKey<MutableList<Member>>("fields")
object StructureDoc : AbstractKey<List<String>>("structureDoc")
