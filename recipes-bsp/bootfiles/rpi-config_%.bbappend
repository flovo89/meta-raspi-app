do_deploy:append:raspberrypi5() {
    CONFIG=${DEPLOYDIR}/${BOOTFILES_DIR_NAME}/config.txt

    if [ "${ENABLE_FAN}" = "1" ]; then
        echo "# Enable cooling fan" >>$CONFIG
        echo "dtparam=cooling_fan=on" >>$CONFIG
        echo "# Tepid: 30% fan @ 30'C" >>$CONFIG
        echo "dtparam=fan_temp0=30000" >>$CONFIG
        echo "dtparam=fan_temp0_hyst=3000" >>$CONFIG
        echo "dtparam=fan_temp0_speed=100" >>$CONFIG
        echo "# Warm: 60% fan @ 45'C" >>$CONFIG  
        echo "dtparam=fan_temp1=45000" >>$CONFIG
        echo "dtparam=fan_temp1_hyst=4000" >>$CONFIG
        echo "dtparam=fan_temp1_speed=150" >>$CONFIG
        echo "# Hot: 80% fan @ 55'C" >>$CONFIG
        echo "dtparam=fan_temp2=55000" >>$CONFIG 
        echo "dtparam=fan_temp2_hyst=5000" >>$CONFIG
        echo "dtparam=fan_temp2_speed=200" >>$CONFIG
        echo "# Very Hot: 100% fan @ 65'C" >>$CONFIG
        echo "dtparam=fan_temp3=65000" >>$CONFIG
        echo "dtparam=fan_temp3_hyst=5000" >>$CONFIG
    fi
}