-- **************************************************************
-- This script destroys the database and associated users
-- **************************************************************

-- The following line terminates any active connections to the database so that it can be destroyed
SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE cd = 'climbing_db';

DROP DATABASE climbing_db;

DROP USER final_capstone_owner;
DROP USER final_capstone_appuser;
