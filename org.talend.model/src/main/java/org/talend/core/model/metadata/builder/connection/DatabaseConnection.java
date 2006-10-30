/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.talend.core.model.metadata.builder.connection;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Database Connection</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getDatabaseType <em>Database Type</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getDriverClass <em>Driver Class</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getURL <em>URL</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getPort <em>Port</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getUsername <em>Username</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getPassword <em>Password</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getServerName <em>Server Name</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getDatasourceName <em>Datasource Name</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getFileFieldName <em>File Field Name</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getSchema <em>Schema</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getSID <em>SID</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getSqlSynthax <em>Sql Synthax</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getStringQuote <em>String Quote</em>}</li>
 *   <li>{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getNullChar <em>Null Char</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection()
 * @model
 * @generated
 */
public interface DatabaseConnection extends Connection {
	/**
	 * Returns the value of the '<em><b>Database Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Database Type</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Database Type</em>' attribute.
	 * @see #setDatabaseType(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_DatabaseType()
	 * @model
	 * @generated
	 */
    String getDatabaseType();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getDatabaseType <em>Database Type</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Database Type</em>' attribute.
	 * @see #getDatabaseType()
	 * @generated
	 */
    void setDatabaseType(String value);

	/**
	 * Returns the value of the '<em><b>Driver Class</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Driver Class</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Driver Class</em>' attribute.
	 * @see #setDriverClass(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_DriverClass()
	 * @model
	 * @generated
	 */
    String getDriverClass();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getDriverClass <em>Driver Class</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Driver Class</em>' attribute.
	 * @see #getDriverClass()
	 * @generated
	 */
    void setDriverClass(String value);

	/**
	 * Returns the value of the '<em><b>URL</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>URL</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>URL</em>' attribute.
	 * @see #setURL(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_URL()
	 * @model
	 * @generated
	 */
    String getURL();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getURL <em>URL</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>URL</em>' attribute.
	 * @see #getURL()
	 * @generated
	 */
    void setURL(String value);

	/**
	 * Returns the value of the '<em><b>Port</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Port</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Port</em>' attribute.
	 * @see #setPort(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_Port()
	 * @model
	 * @generated
	 */
    String getPort();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getPort <em>Port</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Port</em>' attribute.
	 * @see #getPort()
	 * @generated
	 */
    void setPort(String value);

	/**
	 * Returns the value of the '<em><b>Username</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Username</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Username</em>' attribute.
	 * @see #setUsername(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_Username()
	 * @model
	 * @generated
	 */
    String getUsername();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getUsername <em>Username</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Username</em>' attribute.
	 * @see #getUsername()
	 * @generated
	 */
    void setUsername(String value);

	/**
	 * Returns the value of the '<em><b>Password</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Password</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Password</em>' attribute.
	 * @see #setPassword(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_Password()
	 * @model
	 * @generated
	 */
    String getPassword();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getPassword <em>Password</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Password</em>' attribute.
	 * @see #getPassword()
	 * @generated
	 */
    void setPassword(String value);

	/**
	 * Returns the value of the '<em><b>Server Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Server Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Server Name</em>' attribute.
	 * @see #setServerName(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_ServerName()
	 * @model
	 * @generated
	 */
    String getServerName();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getServerName <em>Server Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Server Name</em>' attribute.
	 * @see #getServerName()
	 * @generated
	 */
    void setServerName(String value);

	/**
	 * Returns the value of the '<em><b>Datasource Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Datasource Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Datasource Name</em>' attribute.
	 * @see #setDatasourceName(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_DatasourceName()
	 * @model
	 * @generated
	 */
    String getDatasourceName();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getDatasourceName <em>Datasource Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Datasource Name</em>' attribute.
	 * @see #getDatasourceName()
	 * @generated
	 */
    void setDatasourceName(String value);

	/**
	 * Returns the value of the '<em><b>File Field Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>File Field Name</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>File Field Name</em>' attribute.
	 * @see #setFileFieldName(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_FileFieldName()
	 * @model
	 * @generated
	 */
    String getFileFieldName();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getFileFieldName <em>File Field Name</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>File Field Name</em>' attribute.
	 * @see #getFileFieldName()
	 * @generated
	 */
    void setFileFieldName(String value);

	/**
	 * Returns the value of the '<em><b>Schema</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Schema</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Schema</em>' attribute.
	 * @see #setSchema(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_Schema()
	 * @model
	 * @generated
	 */
    String getSchema();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getSchema <em>Schema</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Schema</em>' attribute.
	 * @see #getSchema()
	 * @generated
	 */
    void setSchema(String value);

	/**
	 * Returns the value of the '<em><b>SID</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>SID</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>SID</em>' attribute.
	 * @see #setSID(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_SID()
	 * @model
	 * @generated
	 */
    String getSID();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getSID <em>SID</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>SID</em>' attribute.
	 * @see #getSID()
	 * @generated
	 */
    void setSID(String value);

	/**
	 * Returns the value of the '<em><b>Sql Synthax</b></em>' attribute.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Sql Synthax</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Sql Synthax</em>' attribute.
	 * @see #setSqlSynthax(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_SqlSynthax()
	 * @model
	 * @generated
	 */
    String getSqlSynthax();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getSqlSynthax <em>Sql Synthax</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Sql Synthax</em>' attribute.
	 * @see #getSqlSynthax()
	 * @generated
	 */
    void setSqlSynthax(String value);

	/**
	 * Returns the value of the '<em><b>String Quote</b></em>' attribute.
	 * The default value is <code>"\""</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>String Quote</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>String Quote</em>' attribute.
	 * @see #setStringQuote(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_StringQuote()
	 * @model default="\""
	 * @generated
	 */
    String getStringQuote();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getStringQuote <em>String Quote</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>String Quote</em>' attribute.
	 * @see #getStringQuote()
	 * @generated
	 */
    void setStringQuote(String value);

	/**
	 * Returns the value of the '<em><b>Null Char</b></em>' attribute.
	 * The default value is <code>"000"</code>.
	 * <!-- begin-user-doc -->
     * <p>
     * If the meaning of the '<em>Null Char</em>' attribute isn't clear,
     * there really should be more of a description here...
     * </p>
     * <!-- end-user-doc -->
	 * @return the value of the '<em>Null Char</em>' attribute.
	 * @see #setNullChar(String)
	 * @see org.talend.core.model.metadata.builder.connection.ConnectionPackage#getDatabaseConnection_NullChar()
	 * @model default="000"
	 * @generated
	 */
    String getNullChar();

	/**
	 * Sets the value of the '{@link org.talend.core.model.metadata.builder.connection.DatabaseConnection#getNullChar <em>Null Char</em>}' attribute.
	 * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Null Char</em>' attribute.
	 * @see #getNullChar()
	 * @generated
	 */
    void setNullChar(String value);

} // DatabaseConnection