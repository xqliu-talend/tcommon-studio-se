/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package orgomg.cwmx.foundation.er.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import orgomg.cwmx.foundation.er.util.ErAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ErItemProviderAdapterFactory extends ErAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
    /**
     * This keeps track of the root adapter factory that delegates to this adapter factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ComposedAdapterFactory parentAdapterFactory;

    /**
     * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected IChangeNotifier changeNotifier = new ChangeNotifier();

    /**
     * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected Collection<Object> supportedTypes = new ArrayList<Object>();

    /**
     * This constructs an instance.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ErItemProviderAdapterFactory() {
        supportedTypes.add(IEditingDomainItemProvider.class);
        supportedTypes.add(IStructuredItemContentProvider.class);
        supportedTypes.add(ITreeItemContentProvider.class);
        supportedTypes.add(IItemLabelProvider.class);
        supportedTypes.add(IItemPropertySource.class);
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.Entity} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EntityItemProvider entityItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.Entity}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createEntityAdapter() {
        if (entityItemProvider == null) {
            entityItemProvider = new EntityItemProvider(this);
        }

        return entityItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.NonuniqueKey} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected NonuniqueKeyItemProvider nonuniqueKeyItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.NonuniqueKey}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createNonuniqueKeyAdapter() {
        if (nonuniqueKeyItemProvider == null) {
            nonuniqueKeyItemProvider = new NonuniqueKeyItemProvider(this);
        }

        return nonuniqueKeyItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.CandidateKey} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected CandidateKeyItemProvider candidateKeyItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.CandidateKey}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createCandidateKeyAdapter() {
        if (candidateKeyItemProvider == null) {
            candidateKeyItemProvider = new CandidateKeyItemProvider(this);
        }

        return candidateKeyItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.ForeignKey} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ForeignKeyItemProvider foreignKeyItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.ForeignKey}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createForeignKeyAdapter() {
        if (foreignKeyItemProvider == null) {
            foreignKeyItemProvider = new ForeignKeyItemProvider(this);
        }

        return foreignKeyItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.Domain} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DomainItemProvider domainItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.Domain}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createDomainAdapter() {
        if (domainItemProvider == null) {
            domainItemProvider = new DomainItemProvider(this);
        }

        return domainItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.Attribute} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected AttributeItemProvider attributeItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.Attribute}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createAttributeAdapter() {
        if (attributeItemProvider == null) {
            attributeItemProvider = new AttributeItemProvider(this);
        }

        return attributeItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.Relationship} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RelationshipItemProvider relationshipItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.Relationship}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRelationshipAdapter() {
        if (relationshipItemProvider == null) {
            relationshipItemProvider = new RelationshipItemProvider(this);
        }

        return relationshipItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.RelationshipEnd} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected RelationshipEndItemProvider relationshipEndItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.RelationshipEnd}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createRelationshipEndAdapter() {
        if (relationshipEndItemProvider == null) {
            relationshipEndItemProvider = new RelationshipEndItemProvider(this);
        }

        return relationshipEndItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.ModelLibrary} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModelLibraryItemProvider modelLibraryItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.ModelLibrary}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createModelLibraryAdapter() {
        if (modelLibraryItemProvider == null) {
            modelLibraryItemProvider = new ModelLibraryItemProvider(this);
        }

        return modelLibraryItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.Model} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected ModelItemProvider modelItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.Model}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createModelAdapter() {
        if (modelItemProvider == null) {
            modelItemProvider = new ModelItemProvider(this);
        }

        return modelItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.SubjectArea} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected SubjectAreaItemProvider subjectAreaItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.SubjectArea}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createSubjectAreaAdapter() {
        if (subjectAreaItemProvider == null) {
            subjectAreaItemProvider = new SubjectAreaItemProvider(this);
        }

        return subjectAreaItemProvider;
    }

    /**
     * This keeps track of the one adapter used for all {@link orgomg.cwmx.foundation.er.PrimaryKey} instances.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected PrimaryKeyItemProvider primaryKeyItemProvider;

    /**
     * This creates an adapter for a {@link orgomg.cwmx.foundation.er.PrimaryKey}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter createPrimaryKeyAdapter() {
        if (primaryKeyItemProvider == null) {
            primaryKeyItemProvider = new PrimaryKeyItemProvider(this);
        }

        return primaryKeyItemProvider;
    }

    /**
     * This returns the root adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public ComposeableAdapterFactory getRootAdapterFactory() {
        return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
    }

    /**
     * This sets the composed adapter factory that contains this factory.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
        this.parentAdapterFactory = parentAdapterFactory;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public boolean isFactoryForType(Object type) {
        return supportedTypes.contains(type) || super.isFactoryForType(type);
    }

    /**
     * This implementation substitutes the factory itself as the key for the adapter.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Adapter adapt(Notifier notifier, Object type) {
        return super.adapt(notifier, this);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    @Override
    public Object adapt(Object object, Object type) {
        if (isFactoryForType(type)) {
            Object adapter = super.adapt(object, type);
            if (!(type instanceof Class) || (((Class<?>)type).isInstance(adapter))) {
                return adapter;
            }
        }

        return null;
    }

    /**
     * This adds a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void addListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.addListener(notifyChangedListener);
    }

    /**
     * This removes a listener.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void removeListener(INotifyChangedListener notifyChangedListener) {
        changeNotifier.removeListener(notifyChangedListener);
    }

    /**
     * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void fireNotifyChanged(Notification notification) {
        changeNotifier.fireNotifyChanged(notification);

        if (parentAdapterFactory != null) {
            parentAdapterFactory.fireNotifyChanged(notification);
        }
    }

    /**
     * This disposes all of the item providers created by this factory. 
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void dispose() {
        if (entityItemProvider != null) entityItemProvider.dispose();
        if (nonuniqueKeyItemProvider != null) nonuniqueKeyItemProvider.dispose();
        if (candidateKeyItemProvider != null) candidateKeyItemProvider.dispose();
        if (foreignKeyItemProvider != null) foreignKeyItemProvider.dispose();
        if (domainItemProvider != null) domainItemProvider.dispose();
        if (attributeItemProvider != null) attributeItemProvider.dispose();
        if (relationshipItemProvider != null) relationshipItemProvider.dispose();
        if (relationshipEndItemProvider != null) relationshipEndItemProvider.dispose();
        if (modelLibraryItemProvider != null) modelLibraryItemProvider.dispose();
        if (modelItemProvider != null) modelItemProvider.dispose();
        if (subjectAreaItemProvider != null) subjectAreaItemProvider.dispose();
        if (primaryKeyItemProvider != null) primaryKeyItemProvider.dispose();
    }

}
