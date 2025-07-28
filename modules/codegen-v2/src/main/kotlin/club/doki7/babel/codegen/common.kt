package club.doki7.babel.codegen

import club.doki7.sennaar.Identifier
import club.doki7.babel.util.buildDoc

internal fun prohibitUserConstruct(className: String) = buildDoc {
    +"/// Constructing this class is nonsense so the constructor is made private."
    +"private $className() {}"
}

internal fun prohibitUserConstruct(ident: Identifier) = prohibitUserConstruct(ident.value)
