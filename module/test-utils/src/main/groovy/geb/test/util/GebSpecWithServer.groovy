/* Copyright 2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *			http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package geb.test.util

import geb.Browser
import spock.lang.*

class GebSpecWithServer extends GebSpec {

	@Shared server
	
	def setupSpec() {
		server = new CallbackHttpServer()
		server.start()
	}
		
	def setup() {
		browser.baseUrl = server.baseUrl
	}
	
	def cleanupSpec() {
		server?.stop()
	}
}