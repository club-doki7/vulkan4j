package club.doki7.babel.extract.sdl3

import club.doki7.sennaar.registry.IdentifierType
import club.doki7.sennaar.registry.Member
import club.doki7.sennaar.registry.Registry
import club.doki7.sennaar.registry.Structure
import club.doki7.sennaar.registry.putEntityIfAbsent

internal fun addSDLGamepadBindings(Registry: Registry) {
    Registry.structs.putEntityIfAbsent(sdl_gamepad_binding)
    Registry.structs.putEntityIfAbsent(sdl_gamepad_binding_input_axis)
    Registry.structs.putEntityIfAbsent(sdl_gamepad_binding_input_hat)
    Registry.structs.putEntityIfAbsent(sdl_gamepad_binding_output_axis)

    Registry.unions.putEntityIfAbsent(sdl_gamepad_binding_input)
    Registry.unions.putEntityIfAbsent(sdl_gamepad_binding_output)

    // Fuck SDL, why would you do this?
    Registry.structs.putEntityIfAbsent(sdl_atomic_int)
    Registry.structs.putEntityIfAbsent(sdl_atomic_u32)
}

// typedef struct SDL_GamepadBinding {
//     SDL_GamepadBindingType input_type;
//     union SDL_GamepadBinding_Input { ... } input;
//     SDL_GamepadBindingType output_type;
//     union SDL_GamepadBinding_Output { ... } output;
// }
private val sdl_gamepad_binding = Structure(
    name = "SDL_GamepadBinding",
    members = mutableListOf(
        mambo("input_type", "SDL_GamepadBindingType"),
        mambo("input", "SDL_GamepadBinding_Input"),
        mambo("output_type", "SDL_GamepadBindingType"),
        mambo("output", "SDL_GamepadBinding_Output"),
    )
)

// union SDL_GamepadBinding_Input {
//     int button;
//     struct SDL_GamepadBinding_Input_Axis { ... } axis;
//     struct SDL_GamepadBinding_Input_Hat { ... } hat;
// }
private val sdl_gamepad_binding_input = Structure(
    name = "SDL_GamepadBinding_Input",
    members = mutableListOf(
        mambo("button", "int"),
        mambo("axis", "SDL_GamepadBinding_Input_Axis"),
        mambo("hat", "SDL_GamepadBinding_Input_Hat")
    )
)

// union SDL_GamepadBinding_Output {
//     SDL_GamepadButton button; // why?
//     struct SDL_GamepadBinding_Output_Axis { ... } axis;
// }
private val sdl_gamepad_binding_output = Structure(
    name = "SDL_GamepadBinding_Output",
    members = mutableListOf(
        mambo("button", "SDL_GamepadButton"),
        mambo("axis", "SDL_GamepadBinding_Output_Axis")
    )
)

// struct SDL_GamepadBinding_Input_Axis {
//     int axis;
//     int axis_min;
//     int axis_max;
// }
private val sdl_gamepad_binding_input_axis = Structure(
    name = "SDL_GamepadBinding_Input_Axis",
    members = mutableListOf(
        mambo("axis", "int"),
        mambo("axis_min", "int"),
        mambo("axis_max", "int")
    )
)

// struct SDL_GamepadBinding_Input_Hat {
//     int hat;
//     int hat_mask;
// }
private val sdl_gamepad_binding_input_hat = Structure(
    name = "SDL_GamepadBinding_Input_Hat",
    members = mutableListOf(
        mambo("hat", "int"),
        mambo("hat_mask", "int")
    )
)

// struct SDL_GamepadBinding_Output_Axis {
//    SDL_GamepadAxis axis; // Why!?
//    int axis_min;
//    int axis_max;
private val sdl_gamepad_binding_output_axis = Structure(
    name = "SDL_GamepadBinding_Output_Axis",
    members = mutableListOf(
        mambo("axis", "SDL_GamepadAxis"), // This is a bit odd, but it is how SDL defines it
        mambo("axis_min", "int"),
        mambo("axis_max", "int")
    )
)

// typedef struct SDL_AtomicInt { int value; } SDL_AtomicInt;
private val sdl_atomic_int = Structure(
    name = "SDL_AtomicInt",
    members = mutableListOf(
        mambo("value", "int")
    )
)

// typedef struct SDL_AtomicU32 { Uint32 value; } SDL_AtomicU32;
private val sdl_atomic_u32 = Structure(
    name = "SDL_AtomicU32",
    members = mutableListOf(
        mambo("value", "Uint32")
    )
)

private fun mambo(name: String, type: String) = Member(
    name = name,
    type = IdentifierType(type),
    values = null,
    len = null,
    altLen = null,
    optional = true,
    bits = null
)
