/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.4
 */
#ifndef __CAMERA_TARGET_TYPES_H__
#define __CAMERA_TARGET_TYPES_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
#include "ivory_serialize.h"
typedef struct camera_target {
            bool valid;
            uint16_t bbox_l;
            uint16_t bbox_r;
            uint16_t bbox_t;
            uint16_t bbox_b;
        } camera_target;
void camera_target_get_le(const uint8_t *n_var0, uint32_t n_var1, struct camera_target *n_var2);
void camera_target_get_be(const uint8_t *n_var0, uint32_t n_var1, struct camera_target *n_var2);
void camera_target_set_le(uint8_t *n_var0, uint32_t n_var1, const struct camera_target *n_var2);
void camera_target_set_be(uint8_t *n_var0, uint32_t n_var1, const struct camera_target *n_var2);

#ifdef __cplusplus
}
#endif
#endif /* __CAMERA_TARGET_TYPES_H__ */
