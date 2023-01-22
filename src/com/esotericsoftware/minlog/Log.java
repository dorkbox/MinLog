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
package com.esotericsoftware.minlog;

/**
 * A low overhead, lightweight logging system.
 * @author Nathan Sweet <misc@n4te.com>
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class Log {
	/** No logging at all. */
    public static final int LEVEL_NONE = 6;
	/** Critical errors. The application may no longer work correctly. */
    public static final int LEVEL_ERROR = 5;
	/** Important warnings. The application will continue to work correctly. */
    public static final int LEVEL_WARN = 4;
	/** Informative messages. Typically used for deployment. */
    public static final int LEVEL_INFO = 3;
	/** Debug messages. This level is useful during development. */
    public static final int LEVEL_DEBUG = 2;
	/** Trace messages. A lot of information is logged, so this level is usually only needed when debugging a problem. */
    public static final int LEVEL_TRACE = 1;

	/**
	 * The level of messages that will be logged. Compiling this and the booleans below as "final" will cause the compiler to
	 * remove all "if (Log.info) ..." type statements below the set level.
	 */
	static private int level = LEVEL_TRACE; // Log everything to delegate control to slf4j

	/** True when the ERROR level will be logged. */
    public static boolean ERROR = level <= LEVEL_ERROR;
	/** True when the WARN level will be logged. */
    public static boolean WARN = level <= LEVEL_WARN;
	/** True when the INFO level will be logged. */
    public static boolean INFO = level <= LEVEL_INFO;
	/** True when the DEBUG level will be logged. */
    public static boolean DEBUG = level <= LEVEL_DEBUG;
	/** True when the TRACE level will be logged. */
    public static boolean TRACE = level <= LEVEL_TRACE;

    /**
     * Gets the version number.
     */
    public static
    String getVersion() {
        return "2.5";
    }

    static {
        // Add this project to the updates system, which verifies this class + UUID + version information
        dorkbox.updates.Updates.INSTANCE.add(Log.class, "967eddd028ae46f884d9a04ff6e3b9d3", getVersion());
    }

    /**
     * Sets the level to log. If a version of this class is being used that has a final log level, this has no affect.
     */
    public static
    void set(int level) {
        // Comment out method contents when compiling fixed level JARs.
        Log.level = level;
        ERROR = level <= LEVEL_ERROR;
        WARN = level <= LEVEL_WARN;
        INFO = level <= LEVEL_INFO;
        DEBUG = level <= LEVEL_DEBUG;
        TRACE = level <= LEVEL_TRACE;
    }

    public static
    void NONE() {
        set(LEVEL_NONE);
    }

    public static
    void ERROR() {
        set(LEVEL_ERROR);
    }

    public static
    void WARN() {
        set(LEVEL_WARN);
    }

    public static
    void INFO() {
        set(LEVEL_INFO);
    }

    public static
    void DEBUG() {
        set(LEVEL_DEBUG);
    }

    public static
    void TRACE() {
        set(LEVEL_TRACE);
    }

    private static Logger logger = new Logger();

    /**
     * Sets the logger that will write the log messages.
     */
    public static
    void setLogger(Logger logger) {
        Log.logger = logger;
    }

    public static
    void error(String message, Throwable ex) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, null, message, ex);
        }
    }

    public static
    void error(String category, String message, Throwable ex) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, category, message, ex);
        }
    }

    public static
    void error(String message) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, null, message, null);
        }
    }

    public static
    void error(String category, String message) {
        if (ERROR) {
            logger.log(LEVEL_ERROR, category, message, null);
        }
    }

    public static
    void warn(String message, Throwable ex) {
        if (WARN) {
            logger.log(LEVEL_WARN, null, message, ex);
        }
    }

    public static
    void warn(String category, String message, Throwable ex) {
        if (WARN) {
            logger.log(LEVEL_WARN, category, message, ex);
        }
    }

    public static
    void warn(String message) {
        if (WARN) {
            logger.log(LEVEL_WARN, null, message, null);
        }
    }

    public static
    void warn(String category, String message) {
        if (WARN) {
            logger.log(LEVEL_WARN, category, message, null);
        }
    }

    public static
    void info(String message, Throwable ex) {
        if (INFO) {
            logger.log(LEVEL_INFO, null, message, ex);
        }
    }

    public static
    void info(String category, String message, Throwable ex) {
        if (INFO) {
            logger.log(LEVEL_INFO, category, message, ex);
        }
    }

    public static
    void info(String message) {
        if (INFO) {
            logger.log(LEVEL_INFO, null, message, null);
        }
    }

    public static
    void info(String category, String message) {
        if (INFO) {
            logger.log(LEVEL_INFO, category, message, null);
        }
    }

    public static
    void debug(String message, Throwable ex) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, null, message, ex);
        }
    }

    public static
    void debug(String category, String message, Throwable ex) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, category, message, ex);
        }
    }

    public static
    void debug(String message) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, null, message, null);
        }
    }

    public static
    void debug(String category, String message) {
        if (DEBUG) {
            logger.log(LEVEL_DEBUG, category, message, null);
        }
    }

    public static
    void trace(String message, Throwable ex) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, null, message, ex);
        }
    }

    public static
    void trace(String category, String message, Throwable ex) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, category, message, ex);
        }
    }

    public static
    void trace(String message) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, null, message, null);
        }
    }

    public static
    void trace(String category, String message) {
        if (TRACE) {
            logger.log(LEVEL_TRACE, category, message, null);
        }
    }

    private
    Log() {
    }

    /**
	 * Performs the actual logging. Default implementation logs to slf4j. Extended and use {@link Log#logger} set to handle
	 * logging differently.
	 */
    public static class Logger {
        // Log as "com.esotericsoftware.minlog"
        public final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Logger.class.getPackage()
                                                                                             .getName());

        public
        void log(int level, String category, String message, Throwable ex) {
            if (level == LEVEL_NONE) {
                return;
            }
            StringBuilder builder = new StringBuilder(256);
            if (category != null) {
                builder.append(category);
                builder.append(": ");
            }
            builder.append(message);
            String line = builder.toString();

            switch (level) {
                case LEVEL_ERROR:
                    logger.error(line, ex);
                    break;
                case LEVEL_WARN:
                    logger.warn(line, ex);
                    break;
                case LEVEL_INFO:
                    logger.info(line, ex);
                    break;
                case LEVEL_DEBUG:
                    logger.debug(line, ex);
                    break;
                case LEVEL_TRACE:
                    logger.trace(line, ex);
                    break;
            }
        }
    }
}

