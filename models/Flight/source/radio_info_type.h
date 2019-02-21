/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.0
 */
#ifndef __RADIO_INFO_TYPE_H__
#define __RADIO_INFO_TYPE_H__
#ifdef __cplusplus
extern "C" {
#endif
#include "ivory.h"
struct radio_info {
    int32_t lat;
    int32_t lon;
    int32_t gps_alt;
    int16_t vx;
    int16_t vy;
    int16_t vz;
    uint32_t time;
} __attribute__((__packed__));

#ifdef __cplusplus
}
#endif
#endif /* __RADIO_INFO_TYPE_H__ */