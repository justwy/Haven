package sh.haven.core.vnc

/**
 * Map a Unicode code point to an X11 KeySym.
 *
 * Latin-1 (U+0020..U+007E, U+00A0..U+00FF) keysyms equal the code point.
 * Every other character must use the Unicode keysym range,
 * `0x01000000 + codepoint` (X11 keysymdef.h / RFB spec). Sending the bare
 * code point for e.g. U+4E2D lands on an unrelated or undefined keysym,
 * so servers silently drop CJK input.
 */
fun unicodeToKeySym(codePoint: Int): Int = when (codePoint) {
    in 0x20..0x7E, in 0xA0..0xFF -> codePoint
    else -> 0x01000000 or codePoint
}
