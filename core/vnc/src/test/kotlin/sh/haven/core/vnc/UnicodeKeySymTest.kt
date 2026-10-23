package sh.haven.core.vnc

import org.junit.Assert.assertEquals
import org.junit.Test

class UnicodeKeySymTest {
    @Test fun asciiMapsDirectly() {
        assertEquals(0x61, unicodeToKeySym('a'.code))
        assertEquals(0x41, unicodeToKeySym('A'.code))
    }

    @Test fun latin1MapsDirectly() {
        assertEquals(0xE9, unicodeToKeySym(0xE9)) // é
    }

    @Test fun cjkUsesUnicodeRange() {
        assertEquals(0x01004E2D, unicodeToKeySym('中'.code))
        assertEquals(0x01006587, unicodeToKeySym('文'.code))
    }

    @Test fun supplementaryUsesUnicodeRange() {
        assertEquals(0x0101F600, unicodeToKeySym(0x1F600)) // 😀
    }
}
