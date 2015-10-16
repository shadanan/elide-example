/*
 * Copyright (c) 2015 Yahoo! Inc. All Rights Reserved.
 */
package com.yahoo.elide.example.roles;

import com.yahoo.elide.core.PersistentResource;
import com.yahoo.elide.security.Check;

/**
 * Role disallowing everyone
 */
public class None implements Check {
    @Override
    public boolean ok(PersistentResource persistentResource) {
        return false;
    }
}
