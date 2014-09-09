KBRANCH_genericx86  = "standard/common-pc/base"
KBRANCH_genericx86-64  = "standard/common-pc-64/base"
KBRANCH_edgerouter = "standard/edgerouter"
KBRANCH_beaglebone = "standard/beaglebone"
KBRANCH_mpc8315e-rdb = "standard/fsl-mpc8315e-rdb"

KMACHINE_genericx86 ?= "common-pc"
KMACHINE_genericx86-64 ?= "common-pc-64"

SRCREV_machine_genericx86 ?= "cc12b028076c0a7de042195fb73998aec351f4f2"
SRCREV_machine_genericx86-64 ?= "47956b735bf67acca4f36af8c3dc18bef3e7c12e"
SRCREV_machine_edgerouter ?= "47956b735bf67acca4f36af8c3dc18bef3e7c12e"
SRCREV_machine_beaglebone ?= "47956b735bf67acca4f36af8c3dc18bef3e7c12e"
SRCREV_machine_mpc8315e-rdb ?= "a6b4507afe330d589193bb50d7d961cd21ee3dd2"

COMPATIBLE_MACHINE_genericx86 = "genericx86"
COMPATIBLE_MACHINE_genericx86-64 = "genericx86-64"
COMPATIBLE_MACHINE_edgerouter = "edgerouter"
COMPATIBLE_MACHINE_beaglebone = "beaglebone"
COMPATIBLE_MACHINE_mpc8315e-rdb = "mpc8315e-rdb"