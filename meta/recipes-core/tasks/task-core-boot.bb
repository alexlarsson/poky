#
# Copyright (C) 2007 OpenedHand Ltd.
#

DESCRIPTION = "Task for OpenedHand Poky - minimal bootable image"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58 \
                    file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
PACKAGE_ARCH = "${MACHINE_ARCH}"
DEPENDS = "virtual/kernel"
ALLOW_EMPTY = "1"
PR = "r9"

#
# Set by the machine configuration with packages essential for device bootup
#
MACHINE_ESSENTIAL_EXTRA_RDEPENDS ?= ""
MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS ?= ""

# Distro can override dev_manager provider
VIRTUAL-RUNTIME_dev_manager ?= "udev"
# Distro can override login_manager provider
VIRTUAL-RUNTIME_login_manager ?= "tinylogin"
# Distro can override init_manager provider
VIRTUAL-RUNTIME_init_manager ?= "sysvinit"
# Distro can override initscripts provider
VIRTUAL-RUNTIME_initscripts ?= "initscripts"

PACKAGES = "\
    task-core-boot \
    task-core-boot-dbg \
    task-core-boot-dev \
"

RDEPENDS_task-core-boot = "\
    base-files \
    base-passwd \
    busybox \
    ${VIRTUAL-RUNTIME_initscripts} \
    ${@base_contains("MACHINE_FEATURES", "keyboard", "keymaps", "", d)} \
    modutils-initscripts \
    netbase \
    ${VIRTUAL-RUNTIME_login_manager} \
    ${VIRTUAL-RUNTIME_init_manager} \
    ${VIRTUAL-RUNTIME_dev_manager} \
    ${VIRTUAL-RUNTIME_update-alternatives} \
    ${MACHINE_ESSENTIAL_EXTRA_RDEPENDS}"

RRECOMMENDS_task-core-boot = "\
    ${MACHINE_ESSENTIAL_EXTRA_RRECOMMENDS}"
