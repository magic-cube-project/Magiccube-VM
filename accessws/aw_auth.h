/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/27, create
 */

# ifndef _AW_AUTH_H_
# define _AW_AUTH_H_

int init_auth(void);

int send_auth_request(nw_ses *ses, uint64_t id, struct clt_info *info, json_t *params);

# endif

