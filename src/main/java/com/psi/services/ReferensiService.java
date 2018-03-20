package com.psi.services;

import java.util.List;

import com.psi.models.Referensi;
public interface ReferensiService {
	public List<Referensi> getAllReferensi();
	public void addReferensi(Referensi referensi);
}
