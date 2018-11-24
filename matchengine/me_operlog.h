/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/01, create
 */

# ifndef _ME_OPERLOG_H_
# define _ME_OPERLOG_H_

# include "me_config.h"

extern uint64_t operlog_id_start;

int init_operlog(void);
int fini_operlog(void);

int append_operlog(const char *method, json_t *params);

bool is_operlog_block(void);
sds operlog_status(sds reply);

# endif

