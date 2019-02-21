/* This file has been autogenerated by Ivory
 * Compiler version  0.1.0.4
 */
#include "frameBuffer_monitor.h"

int32_t frameBuffer_2_ringbuffer_insert = (int32_t) 0 % 4;

int32_t frameBuffer_2_ringbuffer_remove = (int32_t) 0 % 4;

uint8_t frameBuffer_2_ringbuffer_buf[4U][96U];

void callback_push(const uint8_t n_var0[96U])
{
    bool n_r0 = frameBuffer_2_ringbuffer_push(n_var0);
}

void callback_periodic_pop(const int64_t *n_var0)
{
    uint8_t n_local0[96U] = {};
    uint8_t *n_ref1 = n_local0;
    bool n_r2 = frameBuffer_2_ringbuffer_pop(n_ref1);
    
    if (n_r2) {
        callback_cyphertext_decode(n_ref1);
    }
}

bool frameBuffer_2_ringbuffer_push(const uint8_t n_var0[96U])
{
    int32_t n_deref0 = frameBuffer_2_ringbuffer_insert;
    int32_t n_local1 = (int32_t) 0;
    int32_t *n_ref2 = &n_local1;
    
    if ((bool) (n_deref0 == (int32_t) 3)) {
        *n_ref2 = (int32_t) 0;
    } else {
        *n_ref2 = (int32_t) (n_deref0 + (int32_t) 1) % 4;
    }
    
    int32_t n_deref3 = *n_ref2;
    int32_t n_deref4 = frameBuffer_2_ringbuffer_remove;
    
    if ((bool) (n_deref3 == n_deref4)) {
        return false;
    } else {
        int32_t n_deref5 = frameBuffer_2_ringbuffer_insert;
        
        if (frameBuffer_2_ringbuffer_buf[n_deref5] != n_var0)
            memcpy(frameBuffer_2_ringbuffer_buf[n_deref5], n_var0, sizeof(uint8_t [96U]));
        else
            COMPILER_ASSERTS(false);
        
        int32_t n_deref6 = frameBuffer_2_ringbuffer_insert;
        int32_t n_local7 = (int32_t) 0;
        int32_t *n_ref8 = &n_local7;
        
        if ((bool) ((int32_t) 3 == n_deref6)) {
            *n_ref8 = (int32_t) 0;
        } else {
            *n_ref8 = (int32_t) ((int32_t) 1 + n_deref6) % 4;
        }
        
        int32_t n_deref9 = *n_ref8;
        
        frameBuffer_2_ringbuffer_insert = n_deref9;
        return true;
    }
}

bool frameBuffer_2_ringbuffer_pop(uint8_t n_var0[96U])
{
    int32_t n_deref0 = frameBuffer_2_ringbuffer_insert;
    int32_t n_deref1 = frameBuffer_2_ringbuffer_remove;
    
    if ((bool) (n_deref0 == n_deref1)) {
        return false;
    } else {
        int32_t n_deref2 = frameBuffer_2_ringbuffer_remove;
        
        if (n_var0 != frameBuffer_2_ringbuffer_buf[n_deref2])
            memcpy(n_var0, frameBuffer_2_ringbuffer_buf[n_deref2], sizeof(uint8_t [96U]));
        else
            COMPILER_ASSERTS(false);
        
        int32_t n_deref3 = frameBuffer_2_ringbuffer_remove;
        int32_t n_local4 = (int32_t) 0;
        int32_t *n_ref5 = &n_local4;
        
        if ((bool) (n_deref3 == (int32_t) 3)) {
            *n_ref5 = (int32_t) 0;
        } else {
            *n_ref5 = (int32_t) (n_deref3 + (int32_t) 1) % 4;
        }
        
        int32_t n_deref6 = *n_ref5;
        
        frameBuffer_2_ringbuffer_remove = n_deref6;
        return true;
    }
}
