package club.doki7.opencl.datatype;

import club.doki7.ffm.IPointer;

/// Auxiliary interface for unifying {@link VAImageFormatCLREF} and {@link VAImageFormatCLREF.Ptr} operations.
///
/// See package level documentation for more details.
public sealed interface IVAImageFormatCLREF
    extends IPointer
    permits VAImageFormatCLREF, VAImageFormatCLREF.Ptr
{}
