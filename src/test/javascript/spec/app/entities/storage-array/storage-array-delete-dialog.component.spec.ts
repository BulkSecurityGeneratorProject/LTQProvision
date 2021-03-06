/* tslint:disable max-line-length */
import { ComponentFixture, TestBed, inject, fakeAsync, tick } from '@angular/core/testing';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Observable, of } from 'rxjs';
import { JhiEventManager } from 'ng-jhipster';

import { LtqProvisionTestModule } from '../../../test.module';
import { StorageArrayDeleteDialogComponent } from 'app/entities/storage-array/storage-array-delete-dialog.component';
import { StorageArrayService } from 'app/entities/storage-array/storage-array.service';

describe('Component Tests', () => {
    describe('StorageArray Management Delete Component', () => {
        let comp: StorageArrayDeleteDialogComponent;
        let fixture: ComponentFixture<StorageArrayDeleteDialogComponent>;
        let service: StorageArrayService;
        let mockEventManager: any;
        let mockActiveModal: any;

        beforeEach(() => {
            TestBed.configureTestingModule({
                imports: [LtqProvisionTestModule],
                declarations: [StorageArrayDeleteDialogComponent]
            })
                .overrideTemplate(StorageArrayDeleteDialogComponent, '')
                .compileComponents();
            fixture = TestBed.createComponent(StorageArrayDeleteDialogComponent);
            comp = fixture.componentInstance;
            service = fixture.debugElement.injector.get(StorageArrayService);
            mockEventManager = fixture.debugElement.injector.get(JhiEventManager);
            mockActiveModal = fixture.debugElement.injector.get(NgbActiveModal);
        });

        describe('confirmDelete', () => {
            it('Should call delete service on confirmDelete', inject(
                [],
                fakeAsync(() => {
                    // GIVEN
                    spyOn(service, 'delete').and.returnValue(of({}));

                    // WHEN
                    comp.confirmDelete(123);
                    tick();

                    // THEN
                    expect(service.delete).toHaveBeenCalledWith(123);
                    expect(mockActiveModal.dismissSpy).toHaveBeenCalled();
                    expect(mockEventManager.broadcastSpy).toHaveBeenCalled();
                })
            ));
        });
    });
});
