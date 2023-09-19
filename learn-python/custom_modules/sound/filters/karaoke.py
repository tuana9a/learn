from . import equalizer


def karaoke_mode(value):
    print("karaoke mode: " + str(value))


def karaoke_with_bass():
    equalizer.increase_bass(999)