/*
 * $Id: PatternCacheRandom.java 3351 2007-05-04 12:14:00Z plegall $
 *
 * ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2000 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution,
 *    if any, must include the following acknowledgment:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowledgment may appear in the software itself,
 *    if and wherever such third-party acknowledgments normally appear.
 *
 * 4. The names "Apache" and "Apache Software Foundation", "Jakarta-Oro" 
 *    must not be used to endorse or promote products derived from this
 *    software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache" 
 *    or "Jakarta-Oro", nor may "Apache" or "Jakarta-Oro" appear in their 
 *    name, without prior written permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */


package org.apache.oro.text;

import java.util.*;

import org.apache.oro.text.regex.*;
import org.apache.oro.util.*;

/**
 * This class is a GenericPatternCache subclass implementing a random
 * cache replacement policy.  In other words,
 * patterns are added to the cache until it becomes full.  Once the
 * cache is full, when a new pattern is added to the cache, it replaces
 * a randomly selected pattern in the cache.
 *
 * @version @version@
 * @since 1.0
 * @see GenericPatternCache
 */
public final class PatternCacheRandom extends GenericPatternCache {

  /**
   * Creates a PatternCacheRandom instance with a given cache capacity
   * and initialized to use a given PatternCompiler instance as a pattern
   * compiler.
   * <p>
   * @param capacity  The capacity of the cache.
   * @param compiler  The PatternCompiler to use to compile patterns.
   */
  public PatternCacheRandom(int capacity, PatternCompiler compiler) {
    super(new CacheRandom(capacity), compiler);
  }

  /**
   * Same as:
   * <blockquote><pre>
   * PatternCacheRandom(GenericPatternCache.DEFAULT_CAPACITY, compiler);
   * </pre></blockquote>
   */
  public PatternCacheRandom(PatternCompiler compiler) {
    this(GenericPatternCache.DEFAULT_CAPACITY, compiler);
  }

  /**
   * Same as:
   * <blockquote><pre>
   * PatternCacheRandom(capacity, new Perl5Compiler());
   * </pre></blockquote>
   */
  public PatternCacheRandom(int capacity) {
    this(capacity, new Perl5Compiler());
  }

  /**
   * Same as:
   * <blockquote><pre>
   * PatternCacheRandom(GenericPatternCache.DEFAULT_CAPACITY);
   * </pre></blockquote>
   */
  public PatternCacheRandom() {
    this(GenericPatternCache.DEFAULT_CAPACITY);
  }

}



