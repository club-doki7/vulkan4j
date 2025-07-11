package club.doki7.babel.registry

// 这部分代码来自于 https://github.com/KyleMayes/vulkanalia/blob/176963f3e5e0108ba963224704f147d2799a615d/generator/src/main/kotlin/com/kylemayes/generator/registry/Extract.kt#L744
// 主要是 Kyle Mayes 的工作

class Identifier internal constructor(val original: String) : Comparable<Identifier> {
    private var _value = original
    private var _renamed = false

    val value get() = _value
    val renamed get() = _renamed

    fun rename(value: String) {
        if (value == _value) {
            return
        }

        if (_renamed) {
            error("Identifier $original has already been renamed to $_value, colliding with fresh $value")
        }

        _value = value
        _renamed = true
    }

    fun forceRename(value: String) {
        if (value == _value) {
            return
        }

        _value = value
        _renamed = true
    }

    override fun toString(): String {
        return _value
    }

    override fun equals(other: Any?) = other is Identifier && original == other.original

    override fun hashCode() = original.hashCode()

    override fun compareTo(other: Identifier): Int = original.compareTo(other.original)
}

private val identifiers = mutableMapOf<String, Identifier>()

// Kyle Mayes 在这里处理 Vulkan 的 FlagBits/Flags 类型差异问题
// 我不打算这么搞，因为这个 Registry 不只用于 Vulkan
fun String.intern(): Identifier = identifiers.getOrPut(this) { Identifier(this) }
