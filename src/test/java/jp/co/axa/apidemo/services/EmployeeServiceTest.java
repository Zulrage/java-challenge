package jp.co.axa.apidemo.services;

import jp.co.axa.apidemo.entities.Employee;
import jp.co.axa.apidemo.repositories.EmployeeRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;
import jp.co.axa.apidemo.dto.EmployeeDto;
import jp.co.axa.apidemo.exception.ApiDemoBusinessException;
import jp.co.axa.apidemo.exception.ErrorCode;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Before
    public void setUp() {
        Employee employee = new Employee(1L, "Test", 11111, "Test Dptmt");
        Mockito.when(employeeRepository.findById(1L)).thenReturn(Optional.of(employee));
    }

    @Test
    public void whenExist_returnEmployee() throws Exception {
        EmployeeDto employee = employeeService.getEmployee(1L);
        assertThat(employee != null).isTrue();
        assertThat(employee.getId())
                .isEqualTo(1L);

        Mockito.verify(employeeRepository, VerificationModeFactory.times(1)).findById(Mockito.anyLong());
        Mockito.reset(employeeRepository);
    }

    @Test
    public void whenNotExist_throwApiDemoBusinessException() throws Exception {
        try {
            employeeService.getEmployee(2L);
            // Fail test if no exception have been thrown.
            assertThat(false).isTrue();
        } catch (ApiDemoBusinessException ex) {
            assertThat(ex.getErrorCode())
                    .isEqualTo(ErrorCode.NO_DATA);
        }
        Mockito.verify(employeeRepository, VerificationModeFactory.times(1)).findById(Mockito.anyLong());
        Mockito.reset(employeeRepository);

    }
}
