package com.hyundai.thehandsome.domain.member;

import java.sql.Date;

import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * @Date : 2023. 1. 31.
 * @FileName: Member.java
 * @작성자 : 박성환
 * @설명 : DateBase Member Object
 */

@NoArgsConstructor
@Getter
public class Member {

	private String mId;

	private String mPassword;

	private String mName;

	private String mPhone;

	private String mEmail;

	private String mZipCode;

	private String mAddress1;

	private String mAddress2;

	private Date mBirth;

	private Integer mGender;

	private MemberRole mRole;

	@Builder
	public Member(String mId, String mPassword, String mName, String mPhone, String mEmail, String mZipCode,
			String mAddress1, String mAddress2, Date mBirth, Integer mGender, MemberRole mRole) {
		this.mId = mId;
		this.mPassword = mPassword;
		this.mName = mName;
		this.mPhone = mPhone;
		this.mEmail = mEmail;
		this.mZipCode = mZipCode;
		this.mAddress1 = mAddress1;
		this.mAddress2 = mAddress2;
		this.mBirth = mBirth;
		this.mGender = mGender;
		this.mRole = mRole;
	}

	/**
	 * @param memberFormDto
	 * @param passwordEncoder
	 * @return
	 */
	public static Member createMember(MemberFormDto memberFormDto, PasswordEncoder passwordEncoder) {
		Member member = Member.builder().mId(memberFormDto.getMId())
				.mPassword(passwordEncoder.encode(memberFormDto.getMPassword())) // 암호화처리
				.mName(memberFormDto.getMName()).mPhone(memberFormDto.getMPhone()).mEmail(memberFormDto.getMEmail())
				.mZipCode(memberFormDto.getMZipCode()).mAddress1(memberFormDto.getMAddress1())
				.mAddress2(memberFormDto.getMAddress2()).mBirth(new Date(memberFormDto.getMBirth()))
				.mGender(memberFormDto.getMGender()).mRole(MemberRole.USER).build();
		return member;
	}

	@Override
	public String toString() {
		return "Member [mId=" + mId + ", mPassword=" + mPassword + ", mName=" + mName + ", mPhone=" + mPhone
				+ ", mEmail=" + mEmail + ", mZipCode=" + mZipCode + ", mAddress1=" + mAddress1 + ", mAddress2="
				+ mAddress2 + ", mBirth=" + mBirth + ", mGender=" + mGender + ", mRole=" + mRole + "]";
	}

}
