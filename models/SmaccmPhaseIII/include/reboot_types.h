/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.2
 */
#ifndef __REBOOT_TYPES_H__
#define __REBOOT_TYPES_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "ivory_serialize.h"
#include "reboot_magic_types.h"
typedef struct reboot { uint32_t magic;
} reboot;
void reboot_get_le (const uint8_t * n_var0, uint32_t n_var1, struct reboot * n_var2);
void reboot_get_be (const uint8_t * n_var0, uint32_t n_var1, struct reboot * n_var2);
void reboot_set_le (uint8_t * n_var0, uint32_t n_var1, const struct reboot * n_var2);
void reboot_set_be (uint8_t * n_var0, uint32_t n_var1, const struct reboot * n_var2);

#ifdef __cplusplus
}
#endif
#endif /* __REBOOT_TYPES_H__ */