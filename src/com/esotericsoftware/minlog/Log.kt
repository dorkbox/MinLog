/*
 * Copyright 2026 dorkbox, llc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* Copyright (c) 2008, Nathan Sweet
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following
 * conditions are met:
 *
 * - Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 * - Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following
 * disclaimer in the documentation and/or other materials provided with the distribution.
 * - Neither the name of Esoteric Software nor the names of its contributors may be used to endorse or promote products derived
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING,
 * BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.esotericsoftware.minlog

import dorkbox.updates.Updates.add
import org.slf4j.LoggerFactory

/**
 * A low overhead, lightweight logging system.
 * @author Nathan Sweet <misc></misc>@n4te.com>
 */
@Suppress("unused")
object Log {
    /** No logging at all.  */
    const val LEVEL_NONE: Int = 6

    /** Critical errors. The application may no longer work correctly.  */
    const val LEVEL_ERROR: Int = 5

    /** Important warnings. The application will continue to work correctly.  */
    const val LEVEL_WARN: Int = 4

    /** Informative messages. Typically used for deployment.  */
    const val LEVEL_INFO: Int = 3

    /** Debug messages. This level is useful during development.  */
    const val LEVEL_DEBUG: Int = 2

    /** Trace messages. A lot of information is logged, so this level is usually only needed when debugging a problem.  */
    const val LEVEL_TRACE: Int = 1

    /**
     * The level of messages that will be logged. Compiling this and the booleans below as "final" will cause the compiler to
     * remove all "if (Log.info) ..." type statements below the set level.
     */
    private var level = LEVEL_TRACE // Log everything to delegate control to slf4j

    /** True when the ERROR level will be logged.  */
    var ERROR: Boolean = level <= LEVEL_ERROR

    /** True when the WARN level will be logged.  */
    var WARN: Boolean = level <= LEVEL_WARN

    /** True when the INFO level will be logged.  */
    var INFO: Boolean = level <= LEVEL_INFO

    /** True when the DEBUG level will be logged.  */
    var DEBUG: Boolean = level <= LEVEL_DEBUG

    /** True when the TRACE level will be logged.  */
    var TRACE: Boolean = level <= LEVEL_TRACE

    /**
     * Gets the version number.
     */
    const val version = "3.0"

    init {
        // Add this project to the updates system, which verifies this class + UUID + version information
        add(Log::class.java, "967eddd028ae46f884d9a04ff6e3b9d3", version)
    }

    /**
     * Sets the level to log. If a version of this class is being used that has a final log level, this has no affect.
     */
    fun set(level: Int) {
        // Comment out method contents when compiling fixed level JARs.
        Log.level = level
        ERROR = level <= LEVEL_ERROR
        WARN = level <= LEVEL_WARN
        INFO = level <= LEVEL_INFO
        DEBUG = level <= LEVEL_DEBUG
        TRACE = level <= LEVEL_TRACE
    }

    fun NONE() {
        set(LEVEL_NONE)
    }

    fun ERROR() {
        set(LEVEL_ERROR)
    }

    fun WARN() {
        set(LEVEL_WARN)
    }

    fun INFO() {
        set(LEVEL_INFO)
    }

    fun DEBUG() {
        set(LEVEL_DEBUG)
    }

    fun TRACE() {
        set(LEVEL_TRACE)
    }

    private var logger = Logger()

    /**
     * Sets the logger that will write the log messages.
     */
    fun setLogger(logger: Logger) {
        Log.logger = logger
    }

    fun error(message: String, ex: Throwable? = null) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, null, message, ex)
        }
    }

    fun error(category: String, message: String, ex: Throwable? = null) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, category, message, ex)
        }
    }

    fun error(message: String) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, null, message, null)
        }
    }

    fun error(category: String, message: String) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, category, message, null)
        }
    }

    fun warn(message: String, ex: Throwable? = null) {
        if (WARN) {
            logger.log(LEVEL_WARN, null, message, ex)
        }
    }

    fun warn(category: String, message: String, ex: Throwable? = null) {
        if (WARN) {
            logger.log(LEVEL_WARN, category, message, ex)
        }
    }

    fun warn(message: String) {
        if (WARN) {
            logger.log(LEVEL_WARN, null, message, null)
        }
    }

    fun warn(category: String, message: String) {
        if (WARN) {
            logger.log(LEVEL_WARN, category, message, null)
        }
    }

    fun info(message: String, ex: Throwable? = null) {
        if (INFO) {
            logger.log(LEVEL_INFO, null, message, ex)
        }
    }

    fun info(category: String, message: String, ex: Throwable? = null) {
        if (INFO) {
            logger.log(LEVEL_INFO, category, message, ex)
        }
    }

    fun info(message: String) {
        if (INFO) {
            logger.log(LEVEL_INFO, null, message, null)
        }
    }

    fun info(category: String, message: String) {
        if (INFO) {
            logger.log(LEVEL_INFO, category, message, null)
        }
    }

    fun debug(message: String, ex: Throwable? = null) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, null, message, ex)
        }
    }

    fun debug(category: String, message: String, ex: Throwable? = null) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, category, message, ex)
        }
    }

    fun debug(message: String) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, null, message, null)
        }
    }

    fun debug(category: String, message: String) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, category, message, null)
        }
    }

    fun trace(message: String, ex: Throwable? = null) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, null, message, ex)
        }
    }

    fun trace(category: String, message: String, ex: Throwable? = null) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, category, message, ex)
        }
    }

    fun trace(message: String) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, null, message, null)
        }
    }

    fun trace(category: String, message: String) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, category, message, null)
        }
    }

    /**
     * Performs the actual logging. Default implementation logs to slf4j. Extended and use [Log.logger] set to handle
     * logging differently.
     */
    class Logger {
        // Log as "com.esotericsoftware.minlog"
        val logger: org.slf4j.Logger = LoggerFactory.getLogger(Logger::class.java.getPackage().name)

        fun log(level: Int, category: String?, message: String, ex: Throwable?) {
            if (level == LEVEL_NONE) {
                return
            }
            val builder = StringBuilder(256)
            if (category != null) {
                builder.append(category)
                builder.append(": ")
            }
            builder.append(message)
            val line = builder.toString()

            when (level) {
                LEVEL_ERROR -> logger.error(line, ex)
                LEVEL_WARN  -> logger.warn(line, ex)
                LEVEL_INFO  -> logger.info(line, ex)
                LEVEL_DEBUG -> logger.debug(line, ex)
                LEVEL_TRACE -> logger.trace(line, ex)
            }
        }
    }
}

