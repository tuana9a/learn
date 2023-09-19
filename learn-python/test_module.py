import custom_modules
custom_modules.prin("hi hi")

custom_modules.x = 100

from custom_modules import x

print(x)

x = 123

print(x)

# =======================================================
import custom_modules.sound.effects.echo
custom_modules.sound.effects.echo.echo_helloworld()

# =======================================================
from custom_modules.sound.effects import echo
echo.echo_tuana9a()

# =======================================================
from custom_modules.sound.effects.echo import *
echo_helloworld()

# =======================================================
# from sound.effects import *
# NOTE: this import cant do any thing with empty __init__.py

# =======================================================
from custom_modules.sound.filters import *
# NOTE: this import all int __all__=['module1', 'module2']
karaoke.karaoke_mode("on")
# CAUTION: error because only karoke is loaded
# equalizer.increase_bass(10)

# =======================================================
from custom_modules.sound.effects import echo
echo.echo_reverse('co cc')

from custom_modules.sound.filters import karaoke
karaoke.equalizer.decrease_bass(1)
karaoke.karaoke_with_bass()

from custom_modules import x

print(x)
