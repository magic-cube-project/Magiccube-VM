/*
 * Description: 
 *     History: lemon@mofang.com, 2018/09/27, create
 */

# ifndef _AW_ASSET_H_
# define _AW_ASSET_H_

int init_asset(void);

int asset_subscribe(uint32_t user_id, nw_ses *ses, const char *asset);
int asset_unsubscribe(uint32_t user_id, nw_ses *ses);
int asset_on_update(uint32_t user_id, const char *asset);

# endif

