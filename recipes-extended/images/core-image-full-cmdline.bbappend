IMAGE_FSTYPES += "ext4.gz"

IMAGE_INSTALL:append = " \
    transmission \
    network-configuration \
    bluez5 \
    bridge-utils \
    hostapd \
    iptables \
    wpa-supplicant \
    "
