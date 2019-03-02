/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.2
 */
#ifndef __SEQUENCE_NUMBERED_ARMING_STATUS_TYPES_H__
#define __SEQUENCE_NUMBERED_ARMING_STATUS_TYPES_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "arming_status_types.h"
#include "ivory.h"
#include "ivory_serialize.h"
#include "sequence_num_types.h"
typedef struct sequence_numbered_arming_status { uint32_t seqnum;
                                                 struct arming_status val;
} sequence_numbered_arming_status;
void sequence_numbered_arming_status_get_le (const uint8_t * n_var0, uint32_t n_var1, struct sequence_numbered_arming_status * n_var2);
void sequence_numbered_arming_status_get_be (const uint8_t * n_var0, uint32_t n_var1, struct sequence_numbered_arming_status * n_var2);
void sequence_numbered_arming_status_set_le (uint8_t * n_var0, uint32_t n_var1, const struct sequence_numbered_arming_status * n_var2);
void sequence_numbered_arming_status_set_be (uint8_t * n_var0, uint32_t n_var1, const struct sequence_numbered_arming_status * n_var2);

#ifdef __cplusplus
}
#endif
#endif /* __SEQUENCE_NUMBERED_ARMING_STATUS_TYPES_H__ */